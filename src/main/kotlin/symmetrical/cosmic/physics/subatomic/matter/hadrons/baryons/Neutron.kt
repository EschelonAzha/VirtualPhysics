package symmetrical.cosmic.physics.subatomic.matter.hadrons.baryons

import symmetrical.cosmic.physics.atomic.atoms.nucleons.Neutrons
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_hadrons.anti_baryons.AntiNeutron
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter

/*
https://en.wikipedia.org/wiki/Neutron
*/
open class Neutron(
    private val matter: IMatter = Matter(Neutron::class, AntiNeutron::class),
) : Baryon(),
    IMatter by matter
{
    constructor() : this(
        Matter(Neutron::class, AntiNeutron::class),
    ) init {
        this.Neutron()
        // +2/3 wavelength(value),                 Spin(isFormatted),          AngularMomentum(Format),
        // -1/3 wavelength(?),                     Spin(?),                    AngularMomentum(Ptr to Proton),
        // -1/3 wavelength(?),                     Spin(?),                    AngularMomentum(Ptr to Next Neutron),
    }

    lateinit var __neutrons: Neutrons


    override fun absorb(photon: Photon) : Photon {
        matter.check(photon);

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }

    fun setNeutrons(neutrons: Neutrons) : Neutron {
        this.__neutrons = neutrons
        return this
    }

    private fun radiate() : String {
        return matter.getClassId()+
                super.emit().radiate()
    }
}