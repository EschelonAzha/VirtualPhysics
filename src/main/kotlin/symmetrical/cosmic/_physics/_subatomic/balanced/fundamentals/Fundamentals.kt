package symmetrical.cosmic._physics._subatomic.balanced.fundamentals

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.AngularMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.bosons.IEmitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
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
    private var angularMomentum : AngularMomentum               = AngularMomentum()
    private var spin            : Spin                          = Spin()
    private var wavelength      : Wavelength                    = Wavelength()


    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

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
        val propsId     :String                 = matterAntiMatter.getClassId()
        val spinId      :String                 = getSpin().emit().radiate()
        val wavelength  :String                 = getWavelength().emit().radiate()
        return propsId+spinId+wavelength
    }



    fun getSpin() : Spin {
        return spin
    }
    fun getWavelength() : Wavelength {
        return wavelength
    }

    fun setSpin(spin: Spin) : Fundamentals {
        this.spin = spin;
        return this
    }
    override fun toString() : String {
        return wavelength.toString()
    }
}