package symmetrical.physics.subatomic.forces.gravity

import kotlin.reflect.KClass

interface IGravitationalField {

    fun attract         (item:Any)                      : GravitationalField
    fun gravitateTo     (kClass: KClass<*>)             : Any?
    fun orbit           (orbits:IGravitationalField)    : GravitationalField
    fun remove          (item:Any)                      : GravitationalField
    fun setGravity      (gravity:IGravity)              : GravitationalField
}