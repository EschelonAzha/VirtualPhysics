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
import symmetrical.cosmic.physics.subatomic.spacial.Beam
import symmetrical.cosmic.physics.subatomic.spacial.Composition
import symmetrical.cosmic.physics.subatomic.spacial.ParticleBeam

class Spacial : ClassGroup {
    constructor() {
        add(EntityId(Base52.classId(), Beam::class))
        add(EntityId(Base52.classId(), Composition::class))
        add(EntityId(Base52.classId(), ParticleBeam::class))
    }
}