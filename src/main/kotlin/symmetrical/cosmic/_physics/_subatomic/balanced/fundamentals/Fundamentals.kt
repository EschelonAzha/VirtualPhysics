package symmetrical.cosmic._physics._subatomic.balanced.fundamentals

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.AngularMomentumOld
import symmetrical.cosmic._physics._subatomic.bosons.IEmitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.SpinOld
import symmetrical.cosmic._physics._subatomic.luminescent.*

class Fundamentals(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter(Fundamentals::class, Fundamentals::class),
) :
    IMatterAntiMatter by matterAntiMatter,
    IEmitter
{
    constructor() : this(
        MatterAntiMatter(Fundamentals::class, Fundamentals::class),
    )
    private var angularMomentum : AngularMomentumOld           = AngularMomentumOld()
    private var spin            : SpinOld                      = SpinOld()
    private var wavelength      : QuantumField                 = QuantumField()


    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        var (spin, spinRemainder) = Absorber.materialize(photon.propagate())
        setSpin(spin as SpinOld)
        var (wavelength, wavelengthRemainder) = Absorber.materialize(spinRemainder)
        this.wavelength = wavelength as QuantumField
        return Photon(wavelengthRemainder)
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        val propsId     :String                 = matterAntiMatter.getClassId()
        val spinId      :String                 = getSpin().emit().radiate()
        val wavelength  :String                 = getWavelength().emit().radiate()
        return propsId+spinId+wavelength
    }

    fun getAngularMomentum() : AngularMomentumOld {
        return angularMomentum
    }

    fun getPhoton() : Photon {
        return Photon()
    }
    fun getSpin() : SpinOld {
        return spin
    }
    fun getWavelength() : QuantumField {
        return wavelength
    }
    fun setMomentum(momentum: AngularMomentumOld) : Fundamentals {
        this.angularMomentum = momentum;
        return this
    }
    fun setSpin(spin: SpinOld) : Fundamentals {
        this.spin = spin;
        return this
    }
    override fun toString() : String {
        return wavelength.toString()
    }
}