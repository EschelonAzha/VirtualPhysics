package symmetrical.cosmic._physics._subatomic.spacial

import kotlin.reflect.KClass
/*
https://en.wikipedia.org/wiki/Particle_beam
 */
interface IBeam {
    fun add             (obj:Any?)                      : Any?
    fun addAll          (beam: IBeam)                    : IBeam
    fun clear           ()                              : IBeam
    fun compress        ()                              : IBeam
    fun contract        (newSize:Int)                   : IBeam
    fun expand          (newSize:Int)                   : IBeam
    fun get             (pos:Int)                       : Any?
    fun getClassId      ()                              : String
    fun getCore         ()                              : Array<Any?>
    fun find            (item:Any)                      : Int
    fun find            (kClass: KClass<*>)             : Int
    fun isEmpty         ()                              : Boolean
    fun isNotEmpty      ()                              : Boolean
    fun popLeft         ()                              : Any?
    fun remove          (item:Any)                      : Any
    fun removeAt        (pos:Int)                       : Any?
    fun set             (pos:Int, any: Any?)            : Any?
    fun shrink          ()                              : IBeam
    fun size            ()                              : Int
}