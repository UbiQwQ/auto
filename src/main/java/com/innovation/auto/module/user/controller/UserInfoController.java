package com.innovation.auto.module.user.controller;

import com.innovation.auto.entity.User;
import com.innovation.auto.model.APIResult;
import com.innovation.auto.module.register.service.UserService;
import com.innovation.auto.util.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Auther: carver
 * @Date: 2019/1/8 14:27
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
@RestController
public class UserInfoController {

    @Value("${IMAGEHTTP}")
    private String imageHttp;

    @Autowired
    private UserService userService;

    /**
     * 查询用户
     * @param userId
     * @return
     */
    @GetMapping("/user/queryUser")
    public APIResult queryUser(@RequestParam(value = "userId",required = true) Integer userId) {

        APIResult apiResult = new APIResult();
        apiResult.setMsg("login successfully...");
        apiResult.setStatus(Constants.SUCCESS);


        User user = userService.selectUserById(userId);
        if (null != user){

            apiResult.setRes(user);
            return apiResult;

        }else {
            apiResult.setMsg("用户id不能存在");
            apiResult.setStatus(Constants.ERROR2);
            return apiResult;
        }

    }


    /**
     * 修改资料
     * @param userId
     * @param userName
     * @param phone
     * @param birthday
     * @param gender
     * @param avatar
     * @param password
     * @param newPassword
     * @param personal
     * @return
     * @throws IOException
     */
    @PostMapping("/user/updateUser")
    public APIResult updateUser(@RequestParam(value = "userId",required = true) Integer userId,
                                @RequestParam(value = "userName",required = false) String userName,
                                @RequestParam(value = "phone",required = false) String phone,
                                @RequestParam(value = "birthday",required = false) String birthday,
                                @RequestParam(value = "gender",required = false) String gender,
                                @RequestParam(value = "avatar",required = false) MultipartFile avatar,
                                @RequestParam(value = "password",required = false) String password,
                                @RequestParam(value = "newPassword",required = false) String newPassword,
                                @RequestParam(value = "personal",required = false) String personal) throws IOException {

        APIResult apiResult = new APIResult();
        apiResult.setMsg("update successfully...");
        apiResult.setStatus(Constants.SUCCESS);




        User user = userService.selectUserById(userId);

        //密码修改接口
        if (StringUtils.isNotBlank(password) || StringUtils.isNotBlank(newPassword)) {
            if (!StringUtils.isNotBlank(password)){
                apiResult.setMsg("请输入原密码");
                apiResult.setStatus(Constants.ERROR);
                return apiResult;
            }
            if (!StringUtils.isNotBlank(newPassword)){
                apiResult.setMsg("请输入新密码");
                apiResult.setStatus(Constants.ERROR);
                return apiResult;
            }
            if (user.getPassword().equals(password)){
                user.setPassword(newPassword);
                int result = userService.updateByPrimaryKeySelective(user);

                if (result == 1){
                    apiResult.setRes(user);
                    return apiResult;
                }else {
                    apiResult.setMsg("更新失败");
                    apiResult.setStatus(Constants.ERROR2);
                    return apiResult;
                }
            }else {
                apiResult.setMsg("密码不正确");
                apiResult.setStatus(Constants.ERROR2);
                return apiResult;
            }


        }

        //修改个人介绍
        if (StringUtils.isNotBlank(personal)) {
            user.setPersonalProfile(personal);
            int result = userService.updateByPrimaryKeySelective(user);
            if (result == 1){
                apiResult.setRes(user);
                return apiResult;
            }else {
                apiResult.setMsg("更新失败");
                apiResult.setStatus(Constants.ERROR2);
                return apiResult;
            }
        }

        if (StringUtils.isNotBlank(userName)) {
            user.setName(userName);
        }
        if (StringUtils.isNotBlank(phone)){
            user.setPhone(phone);
        }
        if (StringUtils.isNotBlank(birthday)){
            user.setBirthday(birthday);
        }
        if (StringUtils.isNotBlank(gender)){
            user.setGender(gender.equals("男") ? "1" : "0");
        }
        if (null != avatar) {
            //拿到图片原始名称
            String orginFilename = avatar.getOriginalFilename();
            //图片存储路径
            String imagePath = "D:\\Nginx\\AutoImg\\";
            //UUID图片名称
            String imageFilename = UUID.randomUUID() + orginFilename.substring(orginFilename.lastIndexOf("."));
            //新的图片
            File newFile = new File(imagePath + imageFilename);
            //将内存中数据写入服务器磁盘
            avatar.transferTo(newFile);
            user.setHead(imageHttp + imageFilename);
        }

        int result = userService.updateByPrimaryKeySelective(user);

        if (result == 1){

            apiResult.setRes(user);
            return apiResult;

        }else {
            apiResult.setMsg("更新失败");
            apiResult.setStatus(Constants.ERROR2);
            return apiResult;
        }

    }

}
