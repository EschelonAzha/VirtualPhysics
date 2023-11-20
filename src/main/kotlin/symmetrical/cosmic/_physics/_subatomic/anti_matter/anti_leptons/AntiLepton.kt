package symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.Fundamentals
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion


open class AntiLepton(
    private val fermion: IFermion = Fermion(),
) : Particle(),
    IFermion by fermion,
    Emitter
{
    constructor() : this(
        Fermion()
    )

    protected var fundamentals: Fundamentals = Fundamentals()

    private fun check(photon: Photon) : Unit {
        val classId = getLocalClassId()

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
        return getLocalClassId()+fundamentals.emit().radiate()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(AntiLepton::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    open fun i() : AntiLepton {
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
    fun setSpin(spin: Spin) : AntiLepton {
        this.fundamentals.setSpin(spin)
        return this
    }
    fun setValue(value:Any?) : AntiLepton {
        this.setWavelength(value)
        return this
    }
    fun setWavelength(value:Any?) : AntiLepton {
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