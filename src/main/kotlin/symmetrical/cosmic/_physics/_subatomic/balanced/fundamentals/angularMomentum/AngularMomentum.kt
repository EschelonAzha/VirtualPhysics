package symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

open class AngularMomentum(
    private val fermion: IFermion = Fermion(AngularMomentum::class),
) : Particle(),
    IFermion by fermion,
    Emitter {
    constructor() : this(
        Fermion(AngularMomentum::class),
    )



    override fun absorb(photon: Photon) : Photon {
        fermion.check(photon);

        return photon.propagate()
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return fermion.getClassId()
    }
    override fun getClassId() : String {
        return fermion.getClassId()
    }
    open fun format(wavelength: Wavelength) : String {
        return wavelength.toString()
    }
}