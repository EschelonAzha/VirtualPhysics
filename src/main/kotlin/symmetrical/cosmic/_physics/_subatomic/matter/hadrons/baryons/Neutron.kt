package symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Neutrons
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion


open class Neutron(
    private val fermion: IFermion = Fermion(),
) : Baryon(),
    IFermion by fermion
{
    constructor() : this(
        Fermion()
    ) init {
        this.Neutron()
        // +2/3 wavelength(value),                 Spin(isFormatted),          AngularMomentum(Format),
        // -1/3 wavelength(?),                     Spin(?),                    AngularMomentum(Ptr to Proton),
        // -1/3 wavelength(?),                     Spin(?),                    AngularMomentum(Ptr to Next Neutron),
    }

    lateinit var __neutrons: Neutrons


    private fun getLocalClassId() : String {
        return Absorber.getClassId(Neutron::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }

    fun setNeutrons(neutrons:Neutrons) : Neutron {
        this.__neutrons = neutrons
        return this
    }
}