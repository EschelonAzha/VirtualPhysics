package symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum

import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.*

open class AngularMomentum(
    private val matter: IMatter = Matter(AngularMomentum::class, AngularMomentum::class, true),
) :
    IMatter by matter,
    Emitter {
    constructor() : this(
        Matter(AngularMomentum::class, AngularMomentum::class, true),
    )



    override fun absorb(photon: Photon) : Photon {
        matter.check(photon);

        return photon.propagate()
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return matter.getClassId()
    }
    override fun getClassId() : String {
        return matter.getClassId()
    }
    open fun format(wavelength: QuantumPhotonicField) : String {
        return wavelength.toString()
    }
}