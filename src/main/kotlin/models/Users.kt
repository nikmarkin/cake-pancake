package cakepancake.api.v1.models


import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.date


object Users : IntIdTable() {
    var email=varchar("email",255)
    val registerDate=date("registerDate")
    var firstname =varchar("firstname",255)
    var lastname=varchar("lastname",255)
//    var type=varchar("lastname",255)
//    var password=varchar("password", 255)
//    var password=varchar("password", 255)


}


data class User(val id:Int,val name:String,val registerDate:Long)