CREATE TABLE transactions
(
    id           BIGINT PRIMARY KEY,
    account_id   BIGINT      NOT NULL,
    type         VARCHAR(20) NOT NULL,
    amount       BIGINT      NOT NULL,
    reference_id UUID        NOT NULL,
    created_at   TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_tx_account FOREIGN KEY (account_id) REFERENCES account (id)
);

CREATE SEQUENCE transaction_seq START WITH 1 INCREMENT BY 1;

CREATE INDEX idx_tx_account ON transactions (account_id);
CREATE INDEX idx_tx_reference ON transactions (reference_id);