package symmetrical.cosmic.__recycle

import asymmetrical.machine.vm.Classes
import kotlin.reflect.KClass

class EntityId {
    val id:String
    val kClass:KClass<*>
    constructor(id:String, kClass: KClass<*>) {
        this.id = id
        this.kClass = kClass
    }
    fun has(kClass:KClass<*>) : Boolean {
        return this.kClass == kClass
    }
    fun newInstance() : Any? {
        return Classes.createInstance(kClass)
    }
    override fun toString() : String {
        return "["+id+":"+kClass.simpleName+"]"
    }
}