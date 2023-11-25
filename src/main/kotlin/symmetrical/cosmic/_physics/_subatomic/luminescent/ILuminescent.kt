package symmetrical.cosmic._physics._subatomic.luminescent

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import kotlin.reflect.KClass

interface ILuminescent {
    fun check(photon: Photon) : Unit
    fun getClassId()            : String
    fun getIlluminations()      : ParticleBeam
    fun setKClass(kClass: KClass<*>) : ILuminescent
}