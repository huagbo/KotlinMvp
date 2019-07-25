package com.bobo.baselibrary.data.protocal

class BaseResp<out T> (val status:Int, val message:String, val data:T)