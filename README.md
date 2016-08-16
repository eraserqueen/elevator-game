# elevator-game
Making vertical transportation great again

You are the Vertical Transportation Specialist at TW Corp.
Your role is to maximize employee satisfaction when using the elevators, while minimizing the electricity bill.

Building specs:
- The building is 30 stories high.
- There are 1500 employees in the building, evenly spread across floors.
- Employees come in to work between 7 and 9am (rush hour is 8am) and leave between 4pm and 6pm (rush hour is 5pm).
- Some employees have lunch outside between 11am and 1pm (rush hour is 12am).

Employees rate their satisfaction on a scale of 100.
- Waiting for the elevator lowers satisfaction
- A journey with a lot of stops to let other employees in lowers satisfaction
- Satisfaction increases over time while not using elevators
- Some employees prefer waiting a long time for an elevator, as long as it brings them to their floor without stopping.
- Some employees prefer waiting the shortest possible time, even if the elevator stops often before they reach their floor.

Elevators start at their minimum speed of 3 seconds per floor.
- If the elevator's next stop is over 10 floors away, it will accelerate to reach maximum speed after 3 floors, then decelerrate 3 floors before reaching their destination.
- Elevators travel at a maximum speed of 1 second per floor.
- Elevators travel at the same speed going up or down.
- Each floor stop lasts at least 5 seconds for doors to open/close plus a variable amount per people that need to enter/exit
- Electricity cost increases the faster an elevator moves, or the more weight it carries.

Your Dashboard:
- You can see the amount of electricity used by each elevator.
- You can see the weight carried by each elevator.
- You can see the amount of people waiting at ground level.
- You cannot see the amount of people waiting on any other floor.
- You can adjust the number of elevators available.
- You can adjust the programming of each elevator individually (making them express/all stops/or anything in between).
- You can only adjust the elevators at night while employees are away.
- You can see graphical representations of all variables (employee, elevators, electricity)

The game:
- Starts in PAUSED state with clock set to Monday 6:59AM
- You are allowed to build your initial elevator design
- When the PLAY button is pressed, the clocks starts ticking at the rate of 5 game minutes per real second. It can't be PAUSED until the end of the game.
- From 7AM to 7PM employees come in/out and use the elevators
- At the end of the work day, you are allowed to modify elevators again, while the clock keeps ticking
- The cycle repeats for 5 days (Monday to Friday)
- on Friday 7PM the game ends with your final score

Scoring:
- Your score is the inverse of employee dissatisfaction * electricity costs.
- If you score badly for 5 days, you're fired!