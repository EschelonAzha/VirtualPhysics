package symmetrical.cosmic._physics.atomic.atoms.nucleons

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import kotlin.reflect.KClass

interface IProtons {
    fun absorb          (photon: Photon)    : Photon
    fun addProton       (proton: Proton)    : Proton
    fun emit            ()                  : Photon
    fun getAtomicNumber ()                  : Int
    fun getClassId      ()                  : String
    fun getProton       (kClass: KClass<*>) : Proton

    fun setAtomicNumber (number:Int)        : Nucleons
    fun setNucleons     (nucleons:Nucleons) : Nucleons
}