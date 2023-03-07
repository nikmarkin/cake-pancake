package cakepancake.api.v1.models


import ch.qos.logback.core.net.server.Client
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.date


object Orders : IntIdTable() {
    var client=reference("client", Users)
    var master=reference("master", Users).nullable()
    val creationDate=date("register_date")
    val progressDate=date("progress_date")
    val finishDate=date("finish_date")
    val closeDate=date("close_date")
    var status=varchar("status", 255)
    var productName=varchar("product_name", 255)


}


//data class Orders(val id:Int,val name:String,val registerDate:Long)