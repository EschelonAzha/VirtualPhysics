package symmetrical.device

import symmetrical.cosmic._physics.atomic.substance.ions.Compound
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

// NOT COMPLETE.    See WebStorm::WebTerminal for reference

class DeviceInput(
    private val matter: IMatter = Matter(DeviceInput::class, DeviceInput::class, true),
) : Compound(),
    IMatter by matter
{
    constructor() : this(
        Matter(DeviceInput::class, DeviceInput::class, true),
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
        return matter.getClassId()
    }
    override fun i() : DeviceInput {
        super.i()
        return this
    }
}