package hello.file_practice.controller;

import hello.file_practice.domain.Item;
import hello.file_practice.domain.ItemRepository;
import hello.file_practice.domain.UploadFile;
import hello.file_practice.service.FileStore;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriUtils;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;
    private final FileStore fileStore ;
    @GetMapping("/items/new")
    public String newForm(@ModelAttribute ItemForm itemForm){
        return "item-form";
    }
    @PostMapping("/items/new")
    public String save(@ModelAttribute ItemForm itemForm, RedirectAttributes redirectAttributes) throws IOException {
        UploadFile uploadFile = fileStore.storeFile(itemForm.getAttachFile());
        List<UploadFile> uploadFiles = fileStore.storeFiles(itemForm.getImageFiles());
        Item item = new Item();
        item.setItemName(itemForm.getItemName());
        item.setAttachFile(uploadFile);
        item.setImageFiles(uploadFiles);

        itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", item.getId());
        return "redirect:/items/{itemId}";
    }
    @GetMapping("/items/{itemId}")
    public String view(@PathVariable Long itemId, Model model){
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "item-view";
    }

    @GetMapping("/images/{filename}")
    @ResponseBody
    public Resource printImage(@PathVariable String filename) throws MalformedURLException {
        System.out.println("ItemController.printImage");
        return new UrlResource("file:" + fileStore.getFullPath(filename));
    }

    @GetMapping("/attach/{itemId}")
    public ResponseEntity<Resource> download(@PathVariable Long itemId) throws MalformedURLException {
        Item item = itemRepository.findById(itemId);
        String storeFileName = item.getAttachFile().getStoreFileName();
        String uploadFileName = item.getAttachFile().getUploadFileName();
        UrlResource urlResource = new UrlResource("file:" + fileStore.getFullPath(storeFileName));

        String encodingResult = UriUtils.encode(uploadFileName, StandardCharsets.UTF_8);
        String contentDisposition = "attachment; filename=\"" + encodingResult +"\"";
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                .body(urlResource);
    }
}
