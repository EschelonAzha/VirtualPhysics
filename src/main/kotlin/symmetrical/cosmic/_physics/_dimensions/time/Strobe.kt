package symmetrical.cosmic._physics._dimensions.time

import asymmetrical.machine.time.RequestAnimationFrame
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class Strobe (
    private val antiMatter: IAntiMatter = AntiMatter(Strobe::class),

    ) :
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Strobe::class),
    )

    private val requestAnimationFrame = RequestAnimationFrame().i(this)

    override fun getClassId() : String {
        return antiMatter.getClassId()
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