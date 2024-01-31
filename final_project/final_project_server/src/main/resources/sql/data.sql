use project;

insert into body_types values (1, 'Convertible', 'two-door', 5);
insert into body_types values (2, 'Hardtop', 'two-door', 5);

insert into engine_types values (1, '390 V8', 'gas / petrol');
insert into engine_types values (2, '402 V8', 'petrol');
insert into engine_types values (3, '319 V8', 'diesel');
insert into engine_types values (4, '400 V8', 'gas / petrol');

insert into product_colors values (1, 'blue');
insert into product_colors values (2, 'red');
insert into product_colors values (3, 'black');

insert into transmissions values (1, '4 speed automatic');
insert into transmissions values (2, '3 speed automatic');
insert into transmissions values (3, '4 speed manual');

insert into wheel_drives values (1, 'Rear-wheel drive (RWD)');
insert into wheel_drives values (2, 'All-wheel drive (AWD)');
insert into wheel_drives values (3, 'Front-wheel drive (FWD)');

insert into product_characteristics values (1, 1, 1, 1, 1, 1);
insert into product_characteristics values (2, 2, 2, 2, 2, 1);
insert into product_characteristics values (3, 2, 1, 3, 3, 1);
insert into product_characteristics values (4, 2, 3, 2, 2, 1);
insert into product_characteristics values (5, 2, 4, 2, 3, 1);

insert into products values (1, 'Throughout Cadillac''s 121 years of luxury and innovation, one thing has remained the same: the brand has always been about power and presence. From the V16-driven class of the 1930s and the Escalade-driven brawn of the new millennium, to the world class performance of the Blackwings and the breathtaking innovation of the bespoke Celestiq, GM''s top division continues to find easy success with offerings that fully embody the American spirit. Beginning as a design-driven Cadillac halo, the Eldorado would eventually grow into twelve generations of personal luxury cars that defined style, dominated sales and continue to leave lasting impressions in the hearts and minds of enthusiasts. And, pairing phenomenal fashion and first class comfort with 390 cubic inches of tri-power V8, this dazzling Eldorado Biarritz is America''s quintessential boulevard baron. Ready to create your own rolling fan club? Time to ride the fins of success!', '1959 Cadillac Eldorado Biarritz', 163700, 1);
insert into products values (2, 'Introduced in 1958 as Chevrolet''s first foray upmarket, the Impala proved GM''s volume car juggernaut had the strength to be all things to all people. It was the ride your upper class neighbors enjoyed and, like the original Bel Air, it wholly embodied the time of its creation. With that in mind, the detailed restoration of this evocative Bubble Top involved a ground-up mix of nostalgia and convenience that created a better-than-new cruiser. Amenities like a legendary big block and proven Turbo-Hydramatic 3-speed make this the perfect car for fun drives while timeless lines, a stunning interior and miles of smooth paint are sure to keep collectors happy. If you''re looking for a spectacular classic that''s road ready, show ready, and just plain ready to go, this fully-sorted Chevy is the retro chic icon you''ve been dreaming of!', '1960 Chevrolet Impala', 93800, 2);
insert into products values (3, 'OK, Ford fans, we have a real treat for you! When one thinks of the mid-1960s, Chevy often steals the spotlight with their Impala SS409, and Chrysler has their hard-hitting “industrial strength” Belvederes and Polaras; but what about Ford? Sure, a few 427-powered Thunderbolt racers slipped out, but a lot of folks just plain overlook the big Galaxies, and that''s a shame, because they are great cars with a strong following. Presented for your consideration is this gorgeous black-on-black, Z CODE, 390 powered, 4-speed, air-conditioned Galaxie 500 XL coupe, just like the ones Ford used to dominate NASCAR in the ''60s. A true two owner car from one family in Missouri fully restored and showing 56,129 original miles, this is one awesome piece of Ford history. It just received a thorough polish and looks absolutely radiant in that silky Raven Black paint and the amazing trim that Ford used on the top-of-the-line Galaxies.', '1964 Ford Galaxie 500 XL', 35900, 3);
insert into products values (4, 'Virtually everyone knows Plymouth as one of Detroit''s legendary muscle car divisions. And while it eventually spawned some of America''s premier stoplight warriors, the brand itself started as Chrysler''s entry level marque to rival Ford and Chevrolet in both sales and popularity. That means many of the storied muscle cars enthusiasts know and love began as plush people movers like this stylish 1958 Sport Fury. Wrapping an original polysphere V8 and a pushbutton transmission in a tailored interior and a ton of stylish sheetmetal, this all-American cruiser HAS to be one of the coolest Plymouths on the planet! For fans of unique cars, it doesn''t get much better than an Exner era Plymouth. And if you''re a Mopar collector who''s itching for some classic big fin metal that''ll be the star of every cruise night in town, this ''58 Fury is your ticket!', '1958 Plymouth Fury', 56900, 4);
insert into products values (5, 'It''s a real shame that so many enthusiasts overlook Oldsmobile when shopping for an awesome classic. Big block Chevelles and aggressively styled GTOs seem to be naturals when it comes to muscle car wish lists. But, in reality, GM''s ''more proper'' divisions created some of the nastiest stoplight warriors ever unleashed on American streets. Oldsmobile, the General''s humble technology division, definitely did its fair share to glorify the rise of Detroit. And this 5-time Olds Nationals champion is a prime example of their much lauded ''bar brawler in a tuxedo'' sales mentality. Featuring a numbers-matching drivetrain, an intense Spanish Red on Black color combination and an impressive rotisserie restoration, this Olds is one of the coolest A-Bodies on the planet! And if you''re looking for a solid, road-ready classic that''ll turn heads and bring home trophies, it''s your round-trip rocket ride to the moon!', '1967 Oldsmobile 442', 80300, 5);


insert into product_images values (1, '/assets/1959-cadillac-eldorado/1959-cadillac-eldorado-biarritz-1.jpeg', true, 1);
insert into product_images values (2, '/assets/1959-cadillac-eldorado/1959-cadillac-eldorado-biarritz-2.jpeg', false, 1);
insert into product_images values (3, '/assets/1959-cadillac-eldorado/1959-cadillac-eldorado-biarritz-3.jpeg', false, 1);
insert into product_images values (4, '/assets/1959-cadillac-eldorado/1959-cadillac-eldorado-biarritz-4.jpeg', false, 1);
insert into product_images values (5, '/assets/1959-cadillac-eldorado/1959-cadillac-eldorado-biarritz-5.jpeg', false, 1);
insert into product_images values (6, '/assets/1959-cadillac-eldorado/1959-cadillac-eldorado-biarritz-6.jpeg', false, 1);
insert into product_images values (7, '/assets/1959-cadillac-eldorado/1959-cadillac-eldorado-biarritz-7.jpeg', false, 1);
insert into product_images values (8, '/assets/1960-chevrolet-impala/1960-chevrolet-impala-1.jpeg', true, 2);
insert into product_images values (9, '/assets/1960-chevrolet-impala/1960-chevrolet-impala-2.jpeg', false, 2);
insert into product_images values (10, '/assets/1960-chevrolet-impala/1960-chevrolet-impala-3.jpeg', false, 2);
insert into product_images values (11, '/assets/1960-chevrolet-impala/1960-chevrolet-impala-4.jpeg', false, 2);
insert into product_images values (12, '/assets/1960-chevrolet-impala/1960-chevrolet-impala-5.jpeg', false, 2);
insert into product_images values (13, '/assets/1960-chevrolet-impala/1960-chevrolet-impala-6.jpeg', false, 2);
insert into product_images values (14, '/assets/1960-chevrolet-impala/1960-chevrolet-impala-7.jpeg', false, 2);
insert into product_images values (15, '/assets/1964-ford-galaxie/1964-ford-galaxie-500-xl-1.jpeg', true, 3);
insert into product_images values (16, '/assets/1964-ford-galaxie/1964-ford-galaxie-500-xl-2.jpeg', false, 3);
insert into product_images values (17, '/assets/1964-ford-galaxie/1964-ford-galaxie-500-xl-3.jpeg', false, 3);
insert into product_images values (18, '/assets/1964-ford-galaxie/1964-ford-galaxie-500-xl-4.jpeg', false, 3);
insert into product_images values (19, '/assets/1964-ford-galaxie/1964-ford-galaxie-500-xl-5.jpeg', false, 3);
insert into product_images values (20, '/assets/1964-ford-galaxie/1964-ford-galaxie-500-xl-6.jpeg', false, 3);
insert into product_images values (21, '/assets/1964-ford-galaxie/1964-ford-galaxie-500-xl-7.jpeg', false, 3);
insert into product_images values (22, '/assets/1958-plymouth-fury/1958-plymouth-sport-fury-1.jpeg', true, 4);
insert into product_images values (23, '/assets/1958-plymouth-fury/1958-plymouth-sport-fury-2.jpeg', false, 4);
insert into product_images values (24, '/assets/1958-plymouth-fury/1958-plymouth-sport-fury-3.jpeg', false, 4);
insert into product_images values (25, '/assets/1958-plymouth-fury/1958-plymouth-sport-fury-4.jpeg', false, 4);
insert into product_images values (26, '/assets/1958-plymouth-fury/1958-plymouth-sport-fury-5.jpeg', false, 4);
insert into product_images values (27, '/assets/1958-plymouth-fury/1958-plymouth-sport-fury-6.jpeg', false, 4);
insert into product_images values (28, '/assets/1958-plymouth-fury/1958-plymouth-sport-fury-7.jpeg', false, 4);
insert into product_images values (29, '/assets/1967-oldsmobile-442/1967-oldsmobile-442-1.jpeg', true, 5);
insert into product_images values (30, '/assets/1967-oldsmobile-442/1967-oldsmobile-442-2.jpeg', false, 5);
insert into product_images values (31, '/assets/1967-oldsmobile-442/1967-oldsmobile-442-3.jpeg', false, 5);
insert into product_images values (32, '/assets/1967-oldsmobile-442/1967-oldsmobile-442-4.jpeg', false, 5);
insert into product_images values (33, '/assets/1967-oldsmobile-442/1967-oldsmobile-442-5.jpeg', false, 5);
insert into product_images values (34, '/assets/1967-oldsmobile-442/1967-oldsmobile-442-6.jpeg', false, 5);
insert into product_images values (35, '/assets/1967-oldsmobile-442/1967-oldsmobile-442-7.jpeg', false, 5);
