package symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.IEmitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.*

open class AngularMomentumOld(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter(AngularMomentumOld::class, AngularMomentumOld::class),
) :
    IMatterAntiMatter by matterAntiMatter,
    IEmitter {
        private val field = QuantumField()
    constructor() : this(
        Matter(AngularMomentumOld::class, AngularMomentumOld::class),
    )

    override fun absorb(photon: Photon) : Photon {
        return field.absorb(photon.propagate());
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }

    private fun radiate() : String {
        return getLocalClassId()+field.emit().radiate()
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(AngularMomentum::class)
    }

    override fun getClassId() : String {
        return getLocalClassId()
    }
    open fun format(wavelength: QuantumField) : String {
        return wavelength.toString()
    }
}