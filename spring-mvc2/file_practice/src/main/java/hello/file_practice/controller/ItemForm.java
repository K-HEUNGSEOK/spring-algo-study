package hello.file_practice.controller;

import java.util.List;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ItemForm {
    private String itemName;
    private MultipartFile attachFile; //파일 자체를 받을 것
    private List<MultipartFile> imageFiles; //이미지 여러개
}
