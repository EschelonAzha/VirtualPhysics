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
import symmetrical.cosmic.physics.atomic.atoms.states.booleans.QBoolean
import symmetrical.cosmic.physics.atomic.atoms.states.bytes.QByte
import symmetrical.cosmic.physics.atomic.atoms.states.doubles.QDouble
import symmetrical.cosmic.physics.atomic.atoms.states.integers.QInt
import symmetrical.cosmic.physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic.physics.atomic.atoms.states.vectors.QMass

class Atoms : ClassGroup {
    constructor() {
        add(EntityId(Base52.classId(), QBoolean::class))
        add(EntityId(Base52.classId(), QByte::class))
        add(EntityId(Base52.classId(), QDouble::class))
        add(EntityId(Base52.classId(), QInt::class))
        add(EntityId(Base52.classId(), QMass::class))
        add(EntityId(Base52.classId(), QString::class))

    }
}