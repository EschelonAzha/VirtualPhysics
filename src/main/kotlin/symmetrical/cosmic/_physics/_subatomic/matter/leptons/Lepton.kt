package symmetrical.cosmic._physics._subatomic.matter.leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.Fundamentals
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength

import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

open class Lepton(
    private val fermion: IFermion = Fermion(Lepton::class),
) : Particle(),
    IFermion by fermion,
    Emitter
{
    constructor() : this(
        Fermion(Lepton::class),
    )

    protected var fundamentals: Fundamentals = Fundamentals()



    private fun check(photon: Photon) : Unit {
        val classId = fermion.getClassId()

        val radiation = photon.radiate()
        if (radiation.startsWith(classId))
            return
        println("Radiation Leak in: "+this::class.simpleName)
        return;
    }
    override fun absorb(photon: Photon) : Photon {
        check(photon);

        val (clone, remainder) = Absorber.materialize(photon.propagate())
        this.fundamentals = clone as Fundamentals
        return Photon(remainder)
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return fermion.getClassId()+fundamentals.emit().radiate()
    }
    override fun getClassId() : String {
        return fermion.getClassId()
    }
    open fun i() : Lepton {
        return this
    }
//    fun getValue() : Any? {
//        val wavelength:Wavelength = getWavelength()
//        return wavelength.wavelength()
//    }
    fun getPhoton() : Photon {
        return fundamentals.getPhoton()
    }
    fun getSpin() : Spin {
        return fundamentals.getSpin()
    }
    fun getWavelength() : Wavelength {
        return fundamentals.getWavelength()
    }
    fun setSpin(spin: Spin) : Lepton {
        this.fundamentals.setSpin(spin)
        return this
    }
    fun setValue(value:Any?) : Lepton {
        this.setWavelength(value)
        return this
    }
    fun setWavelength(value:Any?) : Lepton {
        this.getWavelength().setWavelength(value)
        return this
    }
    fun spin() : Boolean {
        return getSpin().isPlus()
    }
    fun wavelength() : Any? {
        return getWavelength().wavelength()
    }
    fun wavelengthStr() : String {
        val result = wavelength() ?: return ""
        return result.toString()
    }



}