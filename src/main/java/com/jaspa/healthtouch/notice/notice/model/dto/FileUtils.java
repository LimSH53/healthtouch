package com.jaspa.healthtouch.notice.notice.model.dto;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component
public class FileUtils {

	
	public List<AttachmentDTO> parseFileInfo(int noticeNo, 
			MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
  if(ObjectUtils.isEmpty(multipartHttpServletRequest)) {
    return null;
  }
  
  List<AttachmentDTO> fileList = new ArrayList<>();
  // 파일 저장 경로 설정 
  DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
  ZonedDateTime current = ZonedDateTime.now(); // 오늘날짜 가져오기
  String path = "images/"+current.format(format);
  File file = new File(path);
  if(file.exists() == false) {
    file.mkdirs();
  }

  Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
  String newFileName, originalFileExtension, contentType;
  while(iterator.hasNext()) {
    // iterator.next() == files
    // 화면에서 files로 보낸 파일들 리스트를 가져올수 있다.
    List<MultipartFile> list = multipartHttpServletRequest.getFiles(iterator.next());
    for(MultipartFile multipartFile : list) {
      if(multipartFile.isEmpty() == false) {
        // 파일 확장자 체크는 contentType으로 해야한다. 파일명에서 가져오면 위변조 할수 있기때문이다.
        contentType = multipartFile.getContentType();
        if(ObjectUtils.isEmpty(contentType)) {
          break;
        } else {
          if(contentType.contains("image/jpeg")) {
            originalFileExtension = ".jpg";
          }else if(contentType.contains("image/png")) {
            originalFileExtension = ".png";
          }else if(contentType.contains("image/gif")) {
            originalFileExtension = ".gif";
          }else {
            break;
          }
        }

        // 파일이름은 중복되지 않게 나노타임을 사용했다.
        newFileName = Long.toString(System.nanoTime()) + originalFileExtension;
        AttachmentDTO noticeFile = new AttachmentDTO();
        noticeFile.setNoticeNo(noticeNo);
        noticeFile.setFileType(multipartFile.getSize());
        noticeFile.setFile(multipartFile.getOriginalFilename());
        noticeFile.setEditFile(path + "/" + newFileName);
        fileList.add(noticeFile);

        // 새로운 이름을 변경된 파일을 저장한다.
        file = new File(path + "/" + newFileName);
        multipartFile.transferTo(file);
      }
    }
  }
  return fileList;
}
}
