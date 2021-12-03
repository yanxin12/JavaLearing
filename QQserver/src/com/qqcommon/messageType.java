package com.qqcommon;

public interface messageType {
    String MEASSAG_LOGIN_SUCESSFUL = "1";//登陆成功
    String MEASSAG_LOGIN_FAIL = "2";//登陆失败
    String MEASSAG_COMM_MES = "3";//信息类别为普通信息
    String MEASSAG_GET_ONLINE_FRIEND = "4";//信息类别为请求返回在线用户列表
    String MEASSAG_RET_ONLINE_FRIEND = "5";//信息类别为返回在线用户列表
    String MEASSAG_CLIENT_EXIT = "6";//信息类别为客户端请求退出
    String MEASSAGE_TO_ALL = "7";//消息类型为发送给所有在线好友
    String FILE_TO_CLIENT = "8"; // 消息类型为文件信息传输
    String NEWS = "9"; // 消息类型新闻推送
}


