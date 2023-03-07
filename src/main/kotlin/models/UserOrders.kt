package cakepancake.api.v1.models

import cakepancake.api.v1.models.User.Companion.referrersOn
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.date


object UserOrders : IntIdTable() {
    val user = reference("user", Users)
    val order = reference("order", Orders)
}

class UserOrder(id: EntityID<Int>):IntEntity(id){
    companion object: IntEntityClass<UserOrder>(UserOrders)
    var user by User referencedOn  UserOrders.user
    var order by Order referencedOn  UserOrders.order
}
