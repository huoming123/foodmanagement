package com.design.foodmanagement.pojo.res;

public enum Code {
    SUCCESS(2000),
//    请求参数错误
    BAD_REQUEST(4000),
    //    未授权
    UNAUTHORIZED(4001),
    //    未登入
    NOT_lOG_IN(4022),
//    错误
    ERROR(5000),
    //    数据库错误
    DATABASE_ERROR(5005),
    Null_Pointer(5010);

    int code;
    Code(int code){this.code = code;}
}
