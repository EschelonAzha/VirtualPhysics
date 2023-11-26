package symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Neutrons
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent


open class Neutron(
    private val luminescent: ILuminescent = Luminescent(Neutron::class),
) : Baryon(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(Neutron::class),
    ) init {
        this.Neutron()
        // +2/3 wavelength(value),                 Spin(isFormatted),          AngularMomentum(Format),
        // -1/3 wavelength(?),                     Spin(?),                    AngularMomentum(Ptr to Proton),
        // -1/3 wavelength(?),                     Spin(?),                    AngularMomentum(Ptr to Next Neutron),
    }

    lateinit var __neutrons: Neutrons


    override fun absorb(photon: Photon) : Photon {
        luminescent.check(photon);

        return super.absorb(photon.propagate())
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return luminescent.getClassId()+super.emit().radiate()
    }
    override fun getClassId() : String {
        return luminescent.getClassId()
    }

    fun setNeutrons(neutrons:Neutrons) : Neutron {
        this.__neutrons = neutrons
        return this
    }
}