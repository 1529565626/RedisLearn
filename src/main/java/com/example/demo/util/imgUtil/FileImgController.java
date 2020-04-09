package com.example.demo.util.imgUtil;

import com.example.demo.constant.Constants;
import com.example.demo.constant.ResultConstants;
import com.example.demo.util.ResponseMessage;
import com.example.demo.util.util.UploadFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 * 图片上传
 * </p>
 * ***********************************************
 * BECAUSE OF CHOICE, STICK TO IT.               *
 * ***********************************************
 *
 * @author Yang@Jowim.com
 * @version V1.0
 * @date 2018年10月19日 10:57
 */
@RestController
@RequestMapping(FileImUrl.CONTROLLER)
public class FileImgController {

    /**
     * 图片上传(缓存)
     *
     * @param picture 上传图片名称
     * @param request
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = FileImUrl.IMG_CACHE_UPLOAD, method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage<Object> addImgCacheUpload(@RequestParam("picture") MultipartFile picture, HttpServletRequest request) {
        Map<String, String> file = UploadFile.uploadSingle(picture, request, FileImUrl.PHOTO_CACHE, false);
        return ResponseMessage.ok(Constants.SUCCESS, ResultConstants.RESULT_INFO_SUCCESS, file.get("outputFile"));
    }


}

/**
 * <p>
 * 图片上传接口
 * </p>
 *
 * @author Yang@Jowim.com
 * @version V1.0
 * @date 2018年03月28日 10:43
 */
interface FileImUrl {

    String CONTROLLER = "file_upload";
    //上传图片到缓存接口
    String IMG_CACHE_UPLOAD = "/img_cache_upload.do";
    /**
     * 上传图片缓存
     */
    String PHOTO_CACHE = "photocache/";
    /**
     * 文件后缀 （.）
     */
    String SUFFIX = ".";


}
