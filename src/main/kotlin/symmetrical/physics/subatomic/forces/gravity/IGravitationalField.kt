package symmetrical.physics.subatomic.forces.gravity

import kotlin.reflect.KClass

interface IGravitationalField {

    fun attract         (item:Any)                      : GravitationalField
    fun eject           (item:Any)                      : GravitationalField
    fun gravitate       (kClass: KClass<*>)             : Any?
    fun orbit           (orbits:IGravitationalField)    : GravitationalField

    fun setGravity      (gravity:IGravity)              : GravitationalField
}