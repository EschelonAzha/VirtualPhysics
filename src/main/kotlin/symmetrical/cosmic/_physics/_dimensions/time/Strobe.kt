package symmetrical.cosmic._physics._dimensions.time

import asymmetrical.machine.time.RequestAnimationFrame
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class Strobe (
    private val luminescent: ILuminescent = Luminescent(Strobe::class),

    ) :
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(Strobe::class),
    )

    private val requestAnimationFrame = RequestAnimationFrame().i(this)

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    fun i() : Strobe {
        return this
    }
    fun frame(timestamp:Double): Unit {
        return
    }
    fun start() : Strobe {
        requestAnimationFrame.start()
        return this
    }
}