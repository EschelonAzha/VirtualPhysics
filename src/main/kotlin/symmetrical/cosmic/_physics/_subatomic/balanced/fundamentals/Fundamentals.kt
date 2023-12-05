package symmetrical.cosmic._physics._subatomic.balanced.fundamentals

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.AngularMomentum
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.QuantumPhotonicField

class Fundamentals(
    private val antiMatter: IAntiMatter = AntiMatter(Fundamentals::class, Fundamentals::class),
) : Particle(),
    IAntiMatter by antiMatter,
    Emitter
{
    constructor() : this(
        AntiMatter(Fundamentals::class, Fundamentals::class),
    )
    private var angularMomentum : AngularMomentum           = AngularMomentum()
    private var spin            : Spin                      = Spin()
    private var wavelength      : QuantumPhotonicField      = QuantumPhotonicField()


    override fun absorb(photon: Photon) : Photon {
        antiMatter.check(photon);

        var (spin, spinRemainder) = Absorber.materialize(photon.propagate())
        setSpin(spin as Spin)
        var (wavelength, wavelengthRemainder) = Absorber.materialize(spinRemainder)
        this.wavelength = wavelength as QuantumPhotonicField
        return Photon(wavelengthRemainder)
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        val propsId     :String                 = antiMatter.getClassId()
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
    fun getWavelength() : QuantumPhotonicField {
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