package symmetrical.cosmic.absorber.class_groups
/*
 * This file is part of Virtual Physics.
 *
 * Copyright (C) [2024] Stephen R. DeSofi AKA Eschelon Azha
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import symmetrical.cosmic.absorber.ClassGroup
import symmetrical.cosmic.absorber.EntityId
import symmetrical.cosmic.transpectors.printable_characters.Base52
import symmetrical.cosmic.physics.subatomic.matter.hadrons.mesons.Kaon
import symmetrical.cosmic.physics.subatomic.matter.hadrons.mesons.MinusPion
import symmetrical.cosmic.physics.subatomic.matter.hadrons.mesons.NeutralDownPion
import symmetrical.cosmic.physics.subatomic.matter.hadrons.mesons.NeutralUpPion
import symmetrical.cosmic.physics.subatomic.matter.quarks.*
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_quarks.*


class Quarks : ClassGroup {
    constructor() {
        add(EntityId(Base52.classId(), AntiBottom::class))
        add(EntityId(Base52.classId(), AntiCharm::class))
        add(EntityId(Base52.classId(), AntiDown::class))
        add(EntityId(Base52.classId(), AntiQuark::class))
        add(EntityId(Base52.classId(), AntiStrange::class))
        add(EntityId(Base52.classId(), AntiTop::class))
        add(EntityId(Base52.classId(), AntiUp::class))
        add(EntityId(Base52.classId(), Bottom::class))
        add(EntityId(Base52.classId(), Charm::class))
        add(EntityId(Base52.classId(), Down::class))
        add(EntityId(Base52.classId(), Kaon::class))
        add(EntityId(Base52.classId(), MinusPion::class))
        add(EntityId(Base52.classId(), NeutralDownPion::class))
        add(EntityId(Base52.classId(), NeutralUpPion::class))
        add(EntityId(Base52.classId(), Quark::class))
        add(EntityId(Base52.classId(), Strange::class))
        add(EntityId(Base52.classId(), Top::class))
        add(EntityId(Base52.classId(), Up::class))
    }
}