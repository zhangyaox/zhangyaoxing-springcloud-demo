package com.zhangyaoxing.entity.controller;


import com.zhangyaoxing.entity.entity.Room;
import com.zhangyaoxing.entity.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenhj
 * @since 2020-04-22
 */
@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    IRoomService iRoomService;

    @RequestMapping("/find")
    public Room find(){
        return iRoomService.getById(1);
    }

}

