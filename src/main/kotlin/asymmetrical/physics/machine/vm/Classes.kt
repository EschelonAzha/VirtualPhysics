package asymmetrical.physics.machine.vm

import kotlin.reflect.KClass

object Classes {
    fun <T:Any> createInstance(kClass:KClass<T>) : Any? {

        val constructors = kClass.constructors
        for (constructor in constructors) {
            if (constructor.parameters.isEmpty())
                return constructor.call()
        }
//        for (constructor in constructors) {
//            return constructor.call(Protons(), Neutrons())
//        }
        return null
    }
    fun getSimpleName(obj:Any) : String {
        val kClass = obj::class
        return kClass.simpleName as String
    }
}

