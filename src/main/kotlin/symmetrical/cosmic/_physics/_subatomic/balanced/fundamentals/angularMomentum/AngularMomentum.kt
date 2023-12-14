package symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum

import symmetrical.cosmic._physics._subatomic.bosons.IEmitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.*

open class AngularMomentum(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter(AngularMomentum::class, AngularMomentum::class),
) :
    IMatterAntiMatter by matterAntiMatter,
    IEmitter {
    constructor() : this(
        Matter(AngularMomentum::class, AngularMomentum::class),
    )



    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        return photon.propagate()
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return matterAntiMatter.getClassId()
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    open fun format(wavelength: QuantumField) : String {
        return wavelength.toString()
    }
}