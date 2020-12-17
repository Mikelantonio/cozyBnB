#filename R__room_view.sql
CREATE OR REPLACE VIEW rooms_view AS
SELECT id, description, price, owner_id FROM rooms;

