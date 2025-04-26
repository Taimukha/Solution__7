# Iterator & Mediator Pattern Projects

This repository includes two Java projects demonstrating core design patterns with full bonus features.

---

## 1. Iterator Pattern — Streaming Service Binge Mode

Simulates a streaming platform's episode navigation system where seasons store episodes differently (ArrayList, LinkedList, etc.) but expose a uniform iterator to the UI team.

*Implemented:*
- Normal order iterator (SeasonIterator)
- Reverse order iterator (ReverseSeasonIterator)
- Shuffle order iterator (ShuffleSeasonIterator) — with a fixed random seed
- Full series binge mode (BingeIterator)

*Bonus Features:*
- SkipIntroIterator — Skips the first 30 seconds of each episode
- WatchHistoryFilterIterator — Filters and iterates only over unseen episodes

---

## 2. Mediator Pattern — Airport Tower Simulator

Simulates an airport where planes (PassengerPlane, CargoPlane, Helicopter) communicate through a ControlTower instead of directly.

*Implemented:*
- TowerMediator interface
- ControlTower coordination logic
- Aircraft types and emergency MAYDAY handling

*Bonus Features:*
- Strategy Pattern: FuelPriorityScheduler
- Plugin System: MilitaryPlane loaded dynamically via ServiceLoader
- UML Diagram included (uml/mediator_pattern_uml.png)

---

## Project Status
- All required and bonus features are fully implemented.
- Professional commit history: each major change is properly documented.
- Ready for demonstration and defense.# Solution__7
