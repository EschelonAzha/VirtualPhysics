package symmetrical.cosmic.__recycle.class_groups

import symmetrical.cosmic.__recycle.ClassGroup
import symmetrical.cosmic.__recycle.EntityId
import symmetrical.cosmic.__transpectors.printable_characters.Base52
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiBlue
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiColor
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiGreen
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiRed
import symmetrical.cosmic._physics._subatomic.balanced.color.ChromoCharge
import symmetrical.cosmic._physics._subatomic.balanced.color.ColorCharge
import symmetrical.cosmic._physics._subatomic.balanced.color.QCD
import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic._physics._subatomic.bosons.gluons.*
import symmetrical.cosmic._physics._subatomic.forces.weak_force.Charge
import symmetrical.cosmic._physics._subatomic.forces.weak_force.ChargedWeak
import symmetrical.cosmic._physics._subatomic.forces.weak_force.neutral.ChargedWeakForce
import symmetrical.cosmic._physics._subatomic.matter.colors.Blue
import symmetrical.cosmic._physics._subatomic.matter.colors.Color
import symmetrical.cosmic._physics._subatomic.matter.colors.Green
import symmetrical.cosmic._physics._subatomic.matter.colors.Red

class Charges : ClassGroup {
    constructor() {
        add(EntityId(Base52.classId(), AntiColor::class))
        add(EntityId(Base52.classId(), AntiBlue::class))
        add(EntityId(Base52.classId(), AntiGreen::class))
        add(EntityId(Base52.classId(), AntiRed::class))
        add(EntityId(Base52.classId(), Blue::class))
        add(EntityId(Base52.classId(), Blue_AntiBlue::class))
        add(EntityId(Base52.classId(), Blue_AntiGreen::class))
        add(EntityId(Base52.classId(), Blue_AntiRed::class))
        add(EntityId(Base52.classId(), Charge::class))
        add(EntityId(Base52.classId(), ChargedWeak::class))
        add(EntityId(Base52.classId(), ChargedWeakForce::class))
        add(EntityId(Base52.classId(), ChromoCharge::class))
        add(EntityId(Base52.classId(), Color::class))
        add(EntityId(Base52.classId(), ColorCharge::class))
        add(EntityId(Base52.classId(), Gluon::class))
        add(EntityId(Base52.classId(), Green::class))
        add(EntityId(Base52.classId(), Green_AntiBlue::class))
        add(EntityId(Base52.classId(), Green_AntiGreen::class))
        add(EntityId(Base52.classId(), Green_AntiRed::class))
        add(EntityId(Base52.classId(), QCD::class))
        add(EntityId(Base52.classId(), Red::class))
        add(EntityId(Base52.classId(), Red_AntiBlue::class))
        add(EntityId(Base52.classId(), Red_AntiBlue::class))
        add(EntityId(Base52.classId(), Red_AntiRed::class))
    }
}