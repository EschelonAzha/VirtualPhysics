package symmetrical.device

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics.atomic.substance.ions.Compound
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

// NOT COMPLETE.    See WebStorm::WebTerminal for reference

class DeviceInput(
    private val fermion: IFermion = Fermion(DeviceInput::class),
) : Compound(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(DeviceInput::class),
    )

    object Static {
        const val CURRENT_SIZE   = Compound.Static.LAST+1
        const val EVENT_ARRAY    = Compound.Static.LAST+2;
        const val KEYBOARD       = Compound.Static.LAST+3;
        const val MOUSE          = Compound.Static.LAST+4
        const val NETWORK_ARRAY  = Compound.Static.LAST+5;

        const val LAST           = Static.NETWORK_ARRAY;
    }

    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun i() : DeviceInput {
        super.i()
        return this
    }
}