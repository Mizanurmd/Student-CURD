ALTER TABLE student DROP CONSTRAINT IF EXISTS fk_country;

ALTER TABLE student ADD CONSTRAINT fk_country
    FOREIGN KEY (country_id) REFERENCES country (cId)
        ON DELETE SET NULL
        DEFERRABLE INITIALLY DEFERRED;
