package symmetrical.cosmic.absorber

import symmetrical.cosmic._physics._subatomic.bosons.IEmitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import kotlin.reflect.KClass

interface IAbsorber {
    fun addAll(group:ClassGroup)            : Absorber
    fun createInstance(id:String)           : Any?
    fun getClassId(kClass: KClass<*>)       : String
    fun initialize()                        : Absorber
    fun initialize(group:ClassGroup)        : Absorber
    fun materialize(emission:String)        : Pair<IEmitter, String>
    fun materialize(photon: Photon)         : Pair<IEmitter, String>
    fun newInstance(kClass:KClass<*>)       : Any?
}