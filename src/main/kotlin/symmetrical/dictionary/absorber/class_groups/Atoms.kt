package symmetrical.dictionary.absorber.class_groups
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

import symmetrical.dictionary.absorber.ClassGroup
import symmetrical.dictionary.absorber.EntityId
import symmetrical.transpectors.printable_characters.Base52
import symmetrical.physics.atomic.atoms.states.Binary
import symmetrical.physics.atomic.atoms.states.Octet
import symmetrical.physics.atomic.atoms.states.Real
import symmetrical.physics.atomic.atoms.states.Numeric
import symmetrical.physics.atomic.atoms.states.Text
import symmetrical.physics.atomic.atoms.states.Sequence

class Atoms : ClassGroup() {
    init {
        add(EntityId().with(Base52.classId(), Binary::class))
        add(EntityId().with(Base52.classId(), Octet::class))
        add(EntityId().with(Base52.classId(), Real::class))
        add(EntityId().with(Base52.classId(), Numeric::class))
        add(EntityId().with(Base52.classId(), Sequence::class))
        add(EntityId().with(Base52.classId(), Text::class))
    }
}