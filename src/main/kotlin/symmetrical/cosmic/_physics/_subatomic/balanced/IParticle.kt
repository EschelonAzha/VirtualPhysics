package symmetrical.cosmic._physics._subatomic.balanced

import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.AngularMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.QuantumField


interface IParticle {
    fun createUniqueId()                    : IParticle
    fun getUniqueId   ()                    : String
    fun getClassId    ()                    : String
    fun getSelf       ()                    : IParticle
    fun setSelf       (self: IParticle)     : IParticle

    fun getValue() : Any?
    fun getPhoton() : Photon
    fun getMomentum() : AngularMomentum
    fun getSpin() : Spin
    fun getWL() : QuantumField
    fun setSpin(spin: Spin) : IParticle
    fun setMomentum(momentum: AngularMomentum) : IParticle
    fun setValue(value:Any?) : IParticle
    fun setWavelength(value:Any?) : IParticle
    fun momentum() : String
    fun spin() : Boolean
    fun wavelength() : Any?
    fun wavelengthStr() : String
}