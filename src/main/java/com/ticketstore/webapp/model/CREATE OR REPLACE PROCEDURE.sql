CREATE OR REPLACE PROCEDURE
CreateOrder(pay_method in VARCHAR2, ticket_amnt in NUMBER, cust_id in CHAR, tickCat in CHAR)
AS
custorder_id CHAR(10 CHAR);
ord_time DATE;
price NUMBER(10,2);
mail VARCHAR2(50);
timepaid DATE;
paycode VARCHAR2(10);
match_count number;
BEGIN
    select count(*)
        into match_count
        from CUSTOMER_ORDER
        where customer_id=cust_id
        and pay_stat=0;
    if match_count = 1 then
        dbms_output.put_line('Your Last Order Has Not Been Paid. Pay Your Last Order Before Make Another Order');
    elsif match_count = 0 then
        custorder_id := LPAD(incrmntco.nextval, 10, 'CO00000000');
        ord_time := sysdate;
        price := pricetotal(ticket_amnt, tickCat);
        paycode := code_payment(pay_method);
        select customer.email
            into mail
            from customer
            where customer.id = cust_id;
        INSERT INTO customer_order(id,order_time,delivery_email_address,time_paid,customer_id,total_price,payment_method,payment_code,ticket_amount,pay_stat, TICKET_CATEGORY_ID) VALUES(custorder_id,ord_time,mail,timepaid,cust_id,price,pay_method,paycode,ticket_amnt,0,tickCat);
        dbms_output.put_line('Order Created');
        end if;
	COMMIT;
END;