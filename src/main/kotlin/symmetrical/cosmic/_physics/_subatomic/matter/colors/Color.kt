package symmetrical.cosmic._physics._subatomic.matter.colors

import symmetrical.cosmic._physics._subatomic.balanced.color.ChromoCharge
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

open class Color(
    private val antiMatter: IAntiMatter = AntiMatter(Color::class),
): ChromoCharge(),
    IAntiMatter by antiMatter {

    constructor() : this(
        AntiMatter(Color::class),
    )

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun i() : Color {
        super.i()
        return this
    }
}