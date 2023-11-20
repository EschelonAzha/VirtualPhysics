package symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Neutrons
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement


open class Neutron(
    private val fermion: IQuantumEntanglement = QuantumEntanglement(),
) : Baryon(),
    IQuantumEntanglement by fermion
{
    constructor() : this(
        QuantumEntanglement()
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