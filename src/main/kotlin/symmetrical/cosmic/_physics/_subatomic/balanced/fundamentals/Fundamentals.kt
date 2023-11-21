package symmetrical.cosmic._physics._subatomic.balanced.fundamentals

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.AngularMomentum
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class Fundamentals(
    private val fermion: IFermion = Fermion(Fundamentals::class),
) : Particle(),
    IFermion by fermion,
    Emitter
{
    constructor() : this(
        Fermion(Fundamentals::class),
    )
    private var angularMomentum : AngularMomentum = AngularMomentum()
    private var spin            : Spin            = Spin()
    private var wavelength      : Wavelength      = Wavelength()

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

        var (spin, spinRemainder) = Absorber.materialize(photon.propagate())
        setSpin(spin as Spin)
        var (wavelength, wavelengthRemainder) = Absorber.materialize(spinRemainder)
        this.wavelength = wavelength as Wavelength
        return Photon(wavelengthRemainder)
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        val propsId     :String                 = fermion.getClassId()
        val spinId      :String                 = getSpin().emit().radiate()
        val wavelength  :String                 = getWavelength().emit().radiate()
        return propsId+spinId+wavelength
    }

    fun getAngularMomentum() : AngularMomentum {
        return angularMomentum
    }

    fun getPhoton() : Photon {
        return Photon()
    }
    fun getSpin() : Spin {
        return spin
    }
    fun getWavelength() : Wavelength {
        return wavelength
    }
    fun setMomentum(momentum: AngularMomentum) : Fundamentals {
        this.angularMomentum = momentum;
        return this
    }
    fun setSpin(spin: Spin) : Fundamentals {
        this.spin = spin;
        return this
    }
    override fun toString() : String {
        return wavelength.toString()
    }
}