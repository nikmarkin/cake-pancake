package cakepancake.api.v1.models


import ch.qos.logback.core.net.server.Client
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.date


object Orders : IntIdTable() {
//    val client=reference("client", Users)
//    val master=reference("master", Users).nullable()
    val creationDate=date("register_date")
    val progressDate=date("progress_date")
    val finishDate=date("finish_date")
    val closeDate=date("close_date")
    val status=varchar("status", 255)
    val productName=varchar("product_name", 255)


}

class Order(id: EntityID<Int>): IntEntity(id){
    companion object: IntEntityClass<Order>(Orders)
    var status by Orders.status
    var productName by Orders.productName
    var master by UserOrder referencedOn  UserOrders.user
    var client by UserOrder referencedOn  UserOrders.user
}
