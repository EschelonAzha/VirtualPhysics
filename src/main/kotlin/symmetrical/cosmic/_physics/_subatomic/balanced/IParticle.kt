package symmetrical.cosmic._physics._subatomic.balanced

import symmetrical.cosmic._physics._dimensions.*
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.AngularMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.QuantumField


interface IParticle {
    fun createUniqueId()                    : IParticle
    fun getUniqueId   ()                    : String
    fun getClassId    ()                    : String
    fun getSelf       ()                    : IParticle
    fun setSelf       (self: IParticle)     : IParticle

    fun getAngularMomentum() : AngularMomentum

    fun getTime() : Time
    fun getCharge() : Charge
    fun getSpace() : Space
    fun getMass() : Mass
    fun getTemperature() : Temperature

    fun getSpin() : Spin
    fun getWavelength() : Wavelength

    fun getPhoton() : Photon
    fun setAngularMomentum(angularMomentum:AngularMomentum) : IParticle
    fun setSpin(spin: Spin) : IParticle
    fun setWavelength(value:Any?) : IParticle
    fun spin() : Boolean
    fun wavelength() : Any?
    fun wavelengthStr() : String
}